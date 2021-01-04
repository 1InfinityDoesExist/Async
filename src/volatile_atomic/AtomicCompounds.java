package volatile_atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCompounds {

	static AtomicInteger atomicInt = new AtomicInteger(0);

	public static void main(String[] args) {

		System.out.println(atomicInt.addAndGet(2));
		System.out.println(atomicInt.getAndAdd(10));
		System.out.println(atomicInt.get());
		System.out.println(atomicInt.incrementAndGet());
		System.out.println(atomicInt.getAndIncrement());
		System.out.println(atomicInt.get());
		System.out.println(atomicInt.decrementAndGet());
		System.out.println(atomicInt.getAndDecrement());
		System.out.println(atomicInt.get());
		System.out.println(atomicInt.compareAndSet(12, 20));
		System.out.println(atomicInt.get());
	}
}
