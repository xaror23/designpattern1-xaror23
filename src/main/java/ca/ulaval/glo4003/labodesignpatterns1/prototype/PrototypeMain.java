package ca.ulaval.glo4003.labodesignpatterns1.prototype;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

public class PrototypeMain {

	public static void main(String[] args) {
		System.out.println("Creating 5 polygons");
		Stopwatch watch = Stopwatch.createStarted();
		Polygon2D polygon1 = new Polygon2D(1, 1);
		Polygon2D polygon2 = new Polygon2D(2, 2);
		Polygon2D polygon3 = new Polygon2D(3, -3);
		Polygon2D polygon4 = new Polygon2D(4, 4);
		Polygon2D polygon5 = new Polygon2D(5, -5);

		watch.stop();
		System.out.println(String.format("Created 5 polytons in %s seconds",
				watch.elapsed(TimeUnit.SECONDS)));
		System.out.println(polygon1.toString());
		System.out.println(polygon2.toString());
		System.out.println(polygon3.toString());
		System.out.println(polygon4.toString());
		System.out.println(polygon5.toString());
	}

}
