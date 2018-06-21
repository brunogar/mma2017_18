package mma.legacy.interval;

import static org.junit.Assert.*;
import mma.legacy.interval.Interval;
import mma.legacy.interval.IntervalFactory;
import mma.legacy.interval.Opening;

import org.junit.Test;

public class IntervalTest {

	@Test
	public void midPointTest() {
assertEquals(5, IntervalFactory.getInterval(0, 10, Opening.BOTH_OPENED).midPoint(), 0.0);
assertEquals(5, IntervalFactory.getInterval(0, 10, Opening.LEFT_OPENED).midPoint(), 0.0);
assertEquals(5, IntervalFactory.getInterval(0, 10, Opening.RIGHT_OPENED).midPoint(), 0.0);
assertEquals(5, IntervalFactory.getInterval(0, 10, Opening.UNOPENED).midPoint(), 0.0);
assertEquals(0, IntervalFactory.getInterval(-10, 10, Opening.BOTH_OPENED).midPoint(), 0.0);
assertEquals(0, IntervalFactory.getInterval(-10, 10, Opening.LEFT_OPENED).midPoint(), 0.0);
assertEquals(0, IntervalFactory.getInterval(-10, 10, Opening.RIGHT_OPENED).midPoint(), 0.0);
assertEquals(0, IntervalFactory.getInterval(-10, 10, Opening.UNOPENED).midPoint(), 0.0);
assertEquals(-10, IntervalFactory.getInterval(-15, -5, Opening.BOTH_OPENED).midPoint(), 0.0);
assertEquals(-10, IntervalFactory.getInterval(-15, -5, Opening.LEFT_OPENED).midPoint(), 0.0);
assertEquals(-10, IntervalFactory.getInterval(-15, -5, Opening.RIGHT_OPENED).midPoint(), 0.0);
assertEquals(-10, IntervalFactory.getInterval(-15, -5, Opening.UNOPENED).midPoint(), 0.0);
	}

	@Test
	public void includeValueTest() {
assertFalse(IntervalFactory.getInterval(0, 10, Opening.BOTH_OPENED).includes(-3));
assertFalse(IntervalFactory.getInterval(0, 10, Opening.LEFT_OPENED).includes(-3));
assertFalse(IntervalFactory.getInterval(0, 10, Opening.RIGHT_OPENED).includes(-3));
assertFalse(IntervalFactory.getInterval(0, 10, Opening.UNOPENED).includes(-3));
assertFalse(IntervalFactory.getInterval(0, 10, Opening.BOTH_OPENED).includes(0));
assertFalse(IntervalFactory.getInterval(0, 10, Opening.LEFT_OPENED).includes(0));
assertTrue(IntervalFactory.getInterval(0, 10, Opening.RIGHT_OPENED).includes(0));
assertTrue(IntervalFactory.getInterval(0, 10, Opening.UNOPENED).includes(0));
assertTrue(IntervalFactory.getInterval(0, 10, Opening.BOTH_OPENED).includes(5));
assertTrue(IntervalFactory.getInterval(0, 10, Opening.LEFT_OPENED).includes(5));
assertTrue(IntervalFactory.getInterval(0, 10, Opening.RIGHT_OPENED).includes(5));
assertTrue(IntervalFactory.getInterval(0, 10, Opening.UNOPENED).includes(5));
assertFalse(IntervalFactory.getInterval(0, 10, Opening.BOTH_OPENED).includes(10));
assertTrue(IntervalFactory.getInterval(0, 10, Opening.LEFT_OPENED).includes(10));
assertFalse(IntervalFactory.getInterval(0, 10, Opening.RIGHT_OPENED).includes(10));
assertTrue(IntervalFactory.getInterval(0, 10, Opening.UNOPENED).includes(10));
assertFalse(IntervalFactory.getInterval(0, 10, Opening.BOTH_OPENED).includes(13));
assertFalse(IntervalFactory.getInterval(0, 10, Opening.LEFT_OPENED).includes(13));
assertFalse(IntervalFactory.getInterval(0, 10, Opening.RIGHT_OPENED).includes(13));
assertFalse(IntervalFactory.getInterval(0, 10, Opening.UNOPENED).includes(13));
}

	@Test
	public void includeIntervalTest() {
	
Interval bothOpenedPivot = IntervalFactory.getInterval(20, 35, Opening.BOTH_OPENED);
assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.BOTH_OPENED)));
assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.BOTH_OPENED)));
assertTrue(bothOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.BOTH_OPENED)));
assertTrue(bothOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.BOTH_OPENED)));
assertTrue(bothOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.BOTH_OPENED)));
assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.BOTH_OPENED)));
assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.BOTH_OPENED)));
assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.LEFT_OPENED)));
assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.LEFT_OPENED)));
assertTrue(bothOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.LEFT_OPENED)));
assertTrue(bothOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.LEFT_OPENED)));
assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.LEFT_OPENED)));
assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.LEFT_OPENED)));
assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.LEFT_OPENED)));
assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.RIGHT_OPENED)));
assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.RIGHT_OPENED)));
assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.RIGHT_OPENED)));
assertTrue(bothOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.RIGHT_OPENED)));
assertTrue(bothOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.RIGHT_OPENED)));
assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.RIGHT_OPENED)));
assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.RIGHT_OPENED)));
assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.UNOPENED)));
assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.UNOPENED)));
assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.UNOPENED)));
assertTrue(bothOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.UNOPENED)));
assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.UNOPENED)));
assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.UNOPENED)));
assertFalse(bothOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.UNOPENED)));
Interval leftOpenedPivot = IntervalFactory.getInterval(20, 35, Opening.LEFT_OPENED);
assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.BOTH_OPENED)));
assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.BOTH_OPENED)));
assertTrue(leftOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.BOTH_OPENED)));
assertTrue(leftOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.BOTH_OPENED)));
assertTrue(leftOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.BOTH_OPENED)));
assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.BOTH_OPENED)));
assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.BOTH_OPENED)));
assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.LEFT_OPENED)));
assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.LEFT_OPENED)));
assertTrue(leftOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.LEFT_OPENED)));
assertTrue(leftOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.LEFT_OPENED)));
assertTrue(leftOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.LEFT_OPENED)));
assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.LEFT_OPENED)));
assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.LEFT_OPENED)));
assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.RIGHT_OPENED)));
assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.RIGHT_OPENED)));
assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.RIGHT_OPENED)));
assertTrue(leftOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.RIGHT_OPENED)));
assertTrue(leftOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.RIGHT_OPENED)));
assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.RIGHT_OPENED)));
assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.RIGHT_OPENED)));
assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.UNOPENED)));
assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.UNOPENED)));
assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.UNOPENED)));
assertTrue(leftOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.UNOPENED)));
assertTrue(leftOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.UNOPENED)));
assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.UNOPENED)));
assertFalse(leftOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.UNOPENED)));
Interval rightOpenedPivot = IntervalFactory.getInterval(20, 35, Opening.RIGHT_OPENED);
assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.BOTH_OPENED)));
assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.BOTH_OPENED)));
assertTrue(rightOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.BOTH_OPENED)));
assertTrue(rightOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.BOTH_OPENED)));
assertTrue(rightOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.BOTH_OPENED)));
assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.BOTH_OPENED)));
assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.BOTH_OPENED)));
assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.LEFT_OPENED)));
assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.LEFT_OPENED)));
assertTrue(rightOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.LEFT_OPENED)));
assertTrue(rightOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.LEFT_OPENED)));
assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.LEFT_OPENED)));
assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.LEFT_OPENED)));
assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.LEFT_OPENED)));
assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.RIGHT_OPENED)));
assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.RIGHT_OPENED)));
assertTrue(rightOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.RIGHT_OPENED)));
assertTrue(rightOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.RIGHT_OPENED)));
assertTrue(rightOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.RIGHT_OPENED)));
assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.RIGHT_OPENED)));
assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.RIGHT_OPENED)));
assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.UNOPENED)));
assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.UNOPENED)));
assertTrue(rightOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.UNOPENED)));
assertTrue(rightOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.UNOPENED)));
assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.UNOPENED)));
assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.UNOPENED)));
assertFalse(rightOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.UNOPENED)));
Interval unopenedOpenedPivot = IntervalFactory.getInterval(20, 35, Opening.UNOPENED);
assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.BOTH_OPENED)));
assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.BOTH_OPENED)));
assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.BOTH_OPENED)));
assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.BOTH_OPENED)));
assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.BOTH_OPENED)));
assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.BOTH_OPENED)));
assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.BOTH_OPENED)));
assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.LEFT_OPENED)));
assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.LEFT_OPENED)));
assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.LEFT_OPENED)));
assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.LEFT_OPENED)));
assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.LEFT_OPENED)));
assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.LEFT_OPENED)));
assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.LEFT_OPENED)));
assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.RIGHT_OPENED)));
assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.RIGHT_OPENED)));
assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.RIGHT_OPENED)));
assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.RIGHT_OPENED)));
assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.RIGHT_OPENED)));
assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.RIGHT_OPENED)));
assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.RIGHT_OPENED)));

assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(10, 15, Opening.UNOPENED)));
assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(15, 20, Opening.UNOPENED)));
assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(20, 25, Opening.UNOPENED)));
assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(25, 30, Opening.UNOPENED)));
assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getInterval(30, 35, Opening.UNOPENED)));
assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(35, 40, Opening.UNOPENED)));
assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getInterval(40, 45, Opening.UNOPENED)));

	}

	@Test
	public void hasIntersectionTest() {

		Interval bothOpenedPivot = IntervalFactory.getInterval(20, 40, Opening.BOTH_OPENED);
		
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.LEFT_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.LEFT_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.LEFT_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.LEFT_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.RIGHT_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.RIGHT_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.RIGHT_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.RIGHT_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.UNOPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.UNOPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.UNOPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.UNOPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.UNOPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.UNOPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.UNOPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.UNOPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.UNOPENED)));

Interval leftOpenedPivot = IntervalFactory.getInterval(20, 40, Opening.LEFT_OPENED);
		
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_OPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_OPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.LEFT_OPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.LEFT_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.LEFT_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.LEFT_OPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.RIGHT_OPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.RIGHT_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.RIGHT_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.RIGHT_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.UNOPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.UNOPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.UNOPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.UNOPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.UNOPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.UNOPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.UNOPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.UNOPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.UNOPENED)));
Interval rightOpenedPivot = IntervalFactory.getInterval(20, 40, Opening.RIGHT_OPENED);
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_OPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_OPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.LEFT_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.LEFT_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.LEFT_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.LEFT_OPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.RIGHT_OPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.RIGHT_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.RIGHT_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.RIGHT_OPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.UNOPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.UNOPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.UNOPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.UNOPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.UNOPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.UNOPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.UNOPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.UNOPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.UNOPENED)));
Interval unopenedPivot = IntervalFactory.getInterval(20, 40, Opening.UNOPENED);
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_OPENED)));
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_OPENED)));
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.LEFT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.LEFT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.LEFT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.LEFT_OPENED)));
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.RIGHT_OPENED)));
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.RIGHT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.RIGHT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.RIGHT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.UNOPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.UNOPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.UNOPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.UNOPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.UNOPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.UNOPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.UNOPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.UNOPENED)));
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.UNOPENED)));
}

	@Test
	public void hasIntersectionTest2() {

		Interval bothOpenedPivot = IntervalFactory.getInterval(20, 40, Opening.BOTH_OPENED);
		
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.LEFT_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.LEFT_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.LEFT_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.LEFT_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.RIGHT_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.RIGHT_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.RIGHT_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.RIGHT_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.UNOPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.UNOPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.UNOPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.UNOPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.UNOPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.UNOPENED)));
assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.UNOPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.UNOPENED)));
assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.UNOPENED)));

Interval leftOpenedPivot = IntervalFactory.getInterval(20, 40, Opening.LEFT_OPENED);
		
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_OPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_OPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.LEFT_OPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.LEFT_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.LEFT_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.LEFT_OPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.RIGHT_OPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.RIGHT_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.RIGHT_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.RIGHT_OPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.UNOPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.UNOPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.UNOPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.UNOPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.UNOPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.UNOPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.UNOPENED)));
assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.UNOPENED)));
assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.UNOPENED)));
Interval rightOpenedPivot = IntervalFactory.getInterval(20, 40, Opening.RIGHT_OPENED);
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_OPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_OPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.LEFT_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.LEFT_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.LEFT_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.LEFT_OPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.RIGHT_OPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.RIGHT_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.RIGHT_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.RIGHT_OPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.UNOPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.UNOPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.UNOPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.UNOPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.UNOPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.UNOPENED)));
assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.UNOPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.UNOPENED)));
assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.UNOPENED)));
Interval unopenedPivot = IntervalFactory.getInterval(20, 40, Opening.UNOPENED);
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.BOTH_OPENED)));
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.BOTH_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.BOTH_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.BOTH_OPENED)));
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.LEFT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.LEFT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.LEFT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.LEFT_OPENED)));
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.RIGHT_OPENED)));
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.RIGHT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.RIGHT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.RIGHT_OPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(5, 15, Opening.UNOPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(10, 20, Opening.UNOPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(15, 25, Opening.UNOPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(20, 30, Opening.UNOPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(25, 35, Opening.UNOPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(30, 40, Opening.UNOPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(35, 45, Opening.UNOPENED)));
assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getInterval(40, 50, Opening.UNOPENED)));
assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getInterval(45, 55, Opening.UNOPENED)));
}
	
//	@Test
//	public void intersectionTest() {
//		
//		 Interval bothOpenedPivot = IntervalFactory.getInterval(20, 50, Opening.BOTH_OPENED);
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.LEFT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.RIGHT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.LEFT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.UNOPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.RIGHT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.UNOPENED)));
//		 
//		 Interval unopenedPivot = IntervalFactory.getInterval(20, 50, Opening.UNOPENED);
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.RIGHT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.LEFT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 20, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(10, 20, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.LEFT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.RIGHT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(50, 50, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(50, 60, Opening.RIGHT_OPENED)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 20, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(10, 20, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(50, 50, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(50, 60, Opening.UNOPENED)));
//		 
//	}

}
