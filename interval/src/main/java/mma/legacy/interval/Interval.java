package mma.legacy.interval;

import java.util.logging.Logger;

/**
 * Clase para el ejemplo de trabajo con Legacy
 *
 * @author Agustin
 * Controla operaciones sobre intervalos que pueden ser abiertos o cerrados
 */
public class Interval {
    private static final Logger logger = Logger.getAnonymousLogger();
    private double minimum;  // número entero que indica el limite inferior del intervalo
    private double maximum;  // número entero que indica el limite superior del intervalo
    private Opening opening; // Enumerado que indica si el intervalo es abierto o cerrado

    /**
     * Constructor de la clase
     *
     * @param minimum
     * @param maximum
     * @param opening
     *
     * Los parámetros no deben ser nulos
     */
    public Interval(double minimum, double maximum, Opening opening) {
        this.minimum = minimum;
        this.maximum = maximum;
        this.opening = opening;
        logger.info("Objeto creado");
    }

    /**
     * Este método calcula la división entre 2 de la suma de los límites del intervalo
     *
     * @return resultado de la division
     */
    public double midPoint() {
        return (maximum + minimum) / 2;
    }

    /**
     * Este método mira si un número está dentro de un determiando intervalo
     *
     * @param value valor que se comprobara c
     * @return booleano que afirma si el valor esta incluido dentro del rango
     */
    public boolean includes(double value) {
        logger.info("Entro en el método");
        switch (opening) {
            case BOTH_OPENED:
                return minimum < value && value < maximum;
            case LEFT_OPENED:
                return minimum < value && value <= maximum;
            case RIGHT_OPENED:
                return minimum <= value && value < maximum;
            case UNOPENED:
                return minimum <= value && value <= maximum;
            default:
                return false;
        }
    }

    /**
     * Este método calcula si un intervalo está dentro de un intervalo
     *
     * @param interval evaluado
     * @return booleano que indica si el intervalo esta incluido
     */
    public boolean includes(Interval interval) {
        boolean minimumIncluded = this.includes(interval.minimum);
        boolean maximumIncluded = this.includes(interval.maximum);
        switch (opening) {
            case BOTH_OPENED:
                return checkIntervalIsIncludedWhenBothOpened(interval, minimumIncluded, maximumIncluded);
            case LEFT_OPENED:
                return checkIntervalIsIncludedWhenLeftOpen(interval, minimumIncluded, maximumIncluded);
            case RIGHT_OPENED:
                return checkIntervalIsIncludedWhenRightIsOpen(interval, minimumIncluded, maximumIncluded);
            case UNOPENED:
                return checkIfIntervalISIncludedWhenUnopened(interval, minimumIncluded, maximumIncluded);
            default:
                assert false;
                return false;
        }
    }

    private boolean checkIfIntervalISIncludedWhenUnopened(Interval interval, boolean minimumIncluded, boolean maximumIncluded) {
        switch (interval.opening) {
            case BOTH_OPENED:
                return (minimumIncluded || minimum == interval.minimum) && (maximumIncluded || maximum == interval.maximum);
            case LEFT_OPENED:
                return (minimumIncluded || minimum == interval.minimum)
                        && (maximumIncluded || maximum == interval.maximum);
            case RIGHT_OPENED:
                return (minimumIncluded || minimum == interval.minimum) && (maximumIncluded || maximum == interval.maximum);
            case UNOPENED:
                return (minimumIncluded || minimum == interval.minimum) && (maximumIncluded || maximum == interval.maximum);
            default:
                assert false;
                return false;
        }
    }

    private boolean checkIntervalIsIncludedWhenRightIsOpen(Interval interval, boolean minimumIncluded, boolean maximumIncluded) {
        switch (interval.opening) {
            case BOTH_OPENED:
                return (minimumIncluded || minimum == interval.minimum)
                        && (maximumIncluded || maximum == interval.maximum);
            case LEFT_OPENED:
                return (minimumIncluded || minimum == interval.minimum)
                        && (maximumIncluded);
            case RIGHT_OPENED:
                return (minimumIncluded || minimum == interval.minimum)
                        && (maximumIncluded || maximum == interval.maximum);
            case UNOPENED:
                return (minimumIncluded || minimum == interval.minimum)
                        && (maximumIncluded);
            default:
                assert false;
                return false;
        }
    }

    private boolean checkIntervalIsIncludedWhenLeftOpen(Interval interval, boolean minimumIncluded, boolean maximumIncluded) {
        switch (interval.opening) {
            case BOTH_OPENED:
                return (minimumIncluded || minimum == interval.minimum)
                        && (maximumIncluded || maximum == interval.maximum);
            case LEFT_OPENED:
                return (minimumIncluded || minimum == interval.minimum)
                        && (maximumIncluded || maximum == interval.maximum);
            case RIGHT_OPENED:
                return (minimumIncluded)
                        && (maximumIncluded || maximum == interval.maximum);
            case UNOPENED:
                return (minimumIncluded)
                        && (maximumIncluded || maximum == interval.maximum);
            default:
                assert false;
                return false;
        }
    }

    private boolean checkIntervalIsIncludedWhenBothOpened(Interval interval, boolean minimumIncluded, boolean maximumIncluded) {
        switch (interval.opening) {
            case BOTH_OPENED:
                return (minimumIncluded || minimum == interval.minimum)
                        && (maximumIncluded || maximum == interval.maximum);
            case LEFT_OPENED:
                return (minimumIncluded || minimum == interval.minimum)
                        && (maximumIncluded);
            case RIGHT_OPENED:
                return (minimumIncluded)
                        && (maximumIncluded || maximum == interval.maximum);
            case UNOPENED:
                return (minimumIncluded) && (maximumIncluded);
            default:
                assert false;
                return false;
        }
    }

    /**
     * Este método verifica si el intervalo intersecciona con el intervalo
     *
     * @param interval a verficar
     * @return booleano que verifica si el intervalo intersecciona con el otro
     */

    public boolean intersectsWith(Interval interval) {
        Boolean x = checkIfIntervalsIntersectInMaximum(interval);
        if (x != null) return x;
        Boolean x1 = checkIfIntevalsIntersecInMinimum(interval);
        if (x1 != null) return x1;
        return this.includes(interval.minimum)
                || this.includes(interval.maximum);
    }

    private Boolean checkIfIntevalsIntersecInMinimum(Interval interval) {
        if (maximum == interval.minimum) {
            switch (opening) {
                case BOTH_OPENED:
                case RIGHT_OPENED:
                    return false;
                case LEFT_OPENED:
                case UNOPENED:
                    return interval.opening == Opening.RIGHT_OPENED ||
                            interval.opening == Opening.UNOPENED;
                default:
                    assert false;
                    return false;
            }
        }
        return null;
    }

    private Boolean checkIfIntervalsIntersectInMaximum(Interval interval) {
        if (minimum == interval.maximum) {
            switch (opening) {
                case BOTH_OPENED:
                case LEFT_OPENED:
                    return false;
                case RIGHT_OPENED:
                case UNOPENED:
                    return interval.opening == Opening.LEFT_OPENED ||
                            interval.opening == Opening.UNOPENED;
                default:
                    assert false;
                    return false;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Interval{");
        sb.append("minimum=").append(minimum);
        sb.append(", maximum=").append(maximum);
        sb.append(", opening=").append(opening);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Interval interval = (Interval) o;

        if (Double.compare(interval.minimum, minimum) != 0) return false;
        if (Double.compare(interval.maximum, maximum) != 0) return false;
        return opening == interval.opening;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(minimum);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(maximum);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (opening != null ? opening.hashCode() : 0);
        return result;
    }
}
