package model;

import java.time.Duration;
import java.time.LocalDateTime;

public class FichierHtml extends Fichier {
	
	public FichierHtml(TEAMSProcessor t){
		super(t);
		this.t = t;
		this.content = build();
	}

	
	public String build() {
		
		  String html = "<!DOCTYPE html> \n <html lang=\"fr\"> \n <head> \n <meta charset=\"utf-8\"> ";
	        html += "<title> Attendance Report </title> \n <link rel=\"stylesheet\" media=\"all\" href=\"visu.css\"> \n";
	        html += "</head> \n <body> \n ";
	        html += "<h1> Rapport de connexion </h1>\n" +
	                "\n" +
	                "<div id=\"blockid\">\n" +
	                "<table>\n" +
	                "\t<tr>\n" +
	                "\t\t<th> Date : </th>\n" +
	                "\t\t<td> " + /*this._allpeople.iterator().next().getDate() +*/ " </td>\n" +
	                "\t</tr>\n" +
	                "\t<tr>\n" +
	                "\t\t<th> Heure dﾃｩbut : </th>\n" +
	                "\t\t<td> " + this.t.get_startTime() + " </td>\n" +
	                "\t</tr>\n" +
	                "\t<tr>\n" +
	                "\t\t<th> Heure fin : </th>\n" +
	                "\t\t<td> " + this.t.get_endTime() + " </td>\n" +
	                "\t</tr>\n" +
	                "\t<tr>\n" +
	                "\t\t<th> Cours : </th>\n" +
	                "\t\t<td> CM Bases de donnﾃｩes et programmation Web </td>\n" +
	                "\t</tr>\n" +
	                "\t<tr>\n" +
	                "\t\t<th> Fichier analysﾃｩ : </th>\n" +
	                "\t\t<td> " + this.t.get_fileName() + " </td>\n" +
	                "\t</tr>\n" +
	                "\t<tr>\n" +
	                "\t\t<th> Nombre de connectﾃｩs : </th>\n" +
	                "\t\t<td> " + this.t.get_allpeople() + "  </td>\n" +
	                "\t</tr>\n" +
	                "</table>\n" +
	                "</div>\n" +
	                "\n" +
	                "<h2> Durﾃｩes de connexion</h2>\n" +
	                "\n" +
	                "<p> Pour chaque personne ci-dessous, on retrouve son temps total de connexion sur la plage dﾃｩclarﾃｩe du cours, ainsi qu'un graphe qui indique les pﾃｩriodes de connexion (en vert) et d'absence de connexion (en blanc). En pointant la souris sur une zone, une bulle affiche les instants de dﾃｩbut et de fin de pﾃｩriode. \n" +
	                "</p>";
	        html += "<div id=\"blockpeople\"> ";

	        for (People people : this.t.get_allpeople()) {

	            html += getCode(people);
	        }

		    html += "</div> \n </body> \n </html>";
	        return html;
		
		
	}
	
	
	public String getCode(People p) {
		
		 if ( p.isOutOfPeriod() ) return ("");

	        // duration max, in order to compute images width in percent
	        LocalDateTime startTime = TEAMSDateTimeConverter.StringToLocalDateTime(p.get_start());
	        LocalDateTime endTime = TEAMSDateTimeConverter.StringToLocalDateTime(p.get_stop());
	        Duration delayMax = Duration.between(startTime, endTime);
	        double durationMaxMinutes = Math.abs(delayMax.toSeconds()/60.);

	        String html="";
			html += "<div class=\"datapeople\"> \n";
			html += "<div class=\"name\"> " + p.getName() + " </div> \n";
			html +=	"<div class=\"timebar\">";

	        double totalDuration = 0;
	        LocalDateTime refTime = TEAMSDateTimeConverter.StringToLocalDateTime(p.get_start());
	        for (TEAMSPeriod period : p.get_periodList()) {

	            LocalDateTime begin = period.get_start();
	            LocalDateTime end = period.get_end();
	            double duration = period.getDurationInMinutes();
	            totalDuration += duration;
	            // begin > reftime : white bar
	            Duration delay = Duration.between(refTime, begin);
	            double delayMinutes = Math.abs(delay.toSeconds()/60.);
	            if (delayMinutes>0.0) {
	                html += "<img src=\"off.png\" ";
	                html += "width=\"" + (100.*delayMinutes/durationMaxMinutes) + "%\" ";
	                html += "height=\"20\" title=\"absent(e) de " + refTime.toString();
	                html += " ﾃ� " + begin.toString() + " \"> \n";
	            }
	            // green bar for the current period
	            html += "<img src=\"on.png\" ";
	            html += "width=\"" + (100.*duration/durationMaxMinutes) + "%\" ";
	            html += "height=\"20\" title=\"connectﾃｩ(e) de " + begin.toString();
	            html += " ﾃ� " + end.toString()+ "\"> \n";
	            refTime = end;
	        }
	        // last period aligned on end time ?
	        //LocalDateTime endTime = TEAMSDateTimeConverter.StringToLocalDateTime(this._stop);
	        Duration delay = Duration.between(refTime, endTime);
	        double delayMinutes = Math.abs(delay.toSeconds()/60.);
	        if (delayMinutes>0.0) {
	            html += "<img src=\"off.png\" ";
	            html += "width=\"" + (100.*delayMinutes/durationMaxMinutes) + "%\" ";
	            html += "height=\"20\" title=\"absent(e) de " + refTime.toString();
	            html += " ﾃ� " + endTime.toString() + " \"> \n";
	        }
			html += "</div> \n"; // end of div timebar
	        html +=	"<div class=\"duration\"> " + (long)Math.round(totalDuration) + " </div> \n";
	        html +=	"<div class=\"percentd\"> " + (long)Math.round(100.*totalDuration/durationMaxMinutes) + "% </div> \n";
	        html += "</div>\n"; // end of div datapeople
	        return html;
	}
	
}
