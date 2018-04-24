package July31;

import java.util.Comparator;

public class Car implements Comparable<Car> {
	private String name;
	private int speed;
	private int price;
	
	public static final CarSpeedComp speedComp = new CarSpeedComp();
	public static final CarRevSpeedComp RevspeedComp = new CarRevSpeedComp();
	public static final CarPriceComp PriceComp = new CarPriceComp();
	public static final CarRevPriceComp RevPriceComp = new CarRevPriceComp();
	public static final CarNameComp NameComp = new CarNameComp();
	public static final CarRevNameComp RevNameComp = new CarRevNameComp();


	public Car(String name, int speed, int price) {
		this.name = name;
		this.speed = speed;
		this.price = price;
	}

	@Override
	public int compareTo(Car o) {
//		return this.speed - o.speed;
		return o.price - this.price;
//		return this.name.compareTo(o.name);
	}

	@Override
	public String toString() {
		return "[" + this.name + ", speed = " + this.speed + ", price = " + this.price + "]";
	}
	
	private static class CarSpeedComp implements Comparator<Car> {

		@Override
		public int compare(Car o1, Car o2) {
			return o1.speed - o2.speed;
		}
	}
	
	private static class CarRevSpeedComp implements Comparator<Car> {

		@Override
		public int compare(Car o1, Car o2) {
			return o2.speed - o1.speed;
		}
	}
	
	private static class CarPriceComp implements Comparator<Car> {

		@Override
		public int compare(Car o1, Car o2) {
			return o2.price - o1.price;
		}
	}
	
	private static class CarRevPriceComp implements Comparator<Car> {

		@Override
		public int compare(Car o1, Car o2) {
			return o1.price - o2.price;
		}
	}
	
	private static class CarNameComp implements Comparator<Car> {

		@Override
		public int compare(Car o1, Car o2) {
			return o1.name.compareTo(o2.name);
		}
	}
	
	private static class CarRevNameComp implements Comparator<Car> {

		@Override
		public int compare(Car o1, Car o2) {
			return o2.name.compareTo(o1.name);
		}
	}
}
