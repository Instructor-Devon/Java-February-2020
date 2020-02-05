
public interface Attackable {
	// attackable things must have a health
	int getHealth();
	void setHealth(int health);
	void takeDamage(int damageAmount);
}
