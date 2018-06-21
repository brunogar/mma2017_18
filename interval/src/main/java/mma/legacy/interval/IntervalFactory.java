package mma.legacy.interval;


/**
 * Esta clase abstracta se ha creado por comodidad. 
 * Crea automáticamente intervalos
 * @author Agustin
 *
 */
public class IntervalFactory {

	public static Interval getInterval(double minimum, double maximum, Opening opening) {
		return new Interval(minimum, maximum, opening);
	}
}
