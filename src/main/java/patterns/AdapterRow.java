package patterns;

public class AdapterRow {
	
	public String event;
	public String question;
	public String date;
	public String bet;
	
	public AdapterRow(String ev, String quest, String date, String bet) {
		this.event = ev;
		this.question = quest;
		this.date = date;
		this.bet = bet;
	}
	
	public String getEvent() {
		return this.event;
	}
	
	public String getQuestion() {
		return this.question;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public String getBet() {
		return this.bet;
	}

}
