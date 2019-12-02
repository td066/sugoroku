package sugoroku;

import java.util.Comparator;

public class ComaComparator implements Comparator<Coma> {
	public int compare(Coma coma1, Coma coma2) {
		if (coma1.getMoney() < coma2.getMoney()) {
			return 1;
		} else if (coma1.getMoney() == coma2.getMoney()) {
			return 0;
		} else {
			return -1;
		}
	}
}