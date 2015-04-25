package Classes;

public class Bonus {

	private int bonus;
	
	public Bonus(int bonus) {
		super();
		this.bonus = bonus;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "Bonus [bonus=" + bonus + "]";
	}
}
