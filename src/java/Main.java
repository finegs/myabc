
import java.util.Arrays;
import java.util.Comparator;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.*;
import java.util.concurrent.atomic.*;
import java.util.function.Function;


class Main {
  public static void main(String[] args) throws Exception {

		List<Foo> foos = new ArrayList<>();

		IntStream
				.range(1, 4)
				.forEach(num -> foos.add(new Foo("Foo" + num)));

		foos.forEach(f -> IntStream
				.range(1, 4)
				.forEach(num -> {
					Bar bar = new Bar("Bar" + num + " <- " + f.name);
					bar.setFooName(f.name);
					f.bars.add(bar);
				}));

		foos
				.stream()
				// .sorted((b1, b2) -> b1.name.compareTo(b2.name))
				.flatMap(f -> f.bars.stream())
				.sorted((b1, b2) -> b1.fooName.compareTo(b2.fooName))
				.forEach(System.out::println);
		// Set<String> rs =
		// s1.map(bar->bar.name.split("")).flatMap(Arrays::stream).collect(Collectors.toSet());
		// rs.stream().forEach(System.out::println);
		// .map(bar-> bar.name.split(""));
		// .collect(Collectors.toList())
		// .peek(System.out::println)
		// .flatMap(b-> b.name.chars())
		// .map(Foo::toBars)
		// .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
		// .forEach(System.out::println)
		// .peek(System.out::println);

		String[] hosts = { "localhost", "127.0.0.1", "0.0.0.0", "1.1.1.1" };

		Arrays.stream(hosts)
				.map(wrap(InetAddress::getByName))
				.collect(Collectors.toSet());

		System.out.println("##### End of Main #####");

	}

  interface ExceptionFunction<T,R> {
	R apply(T r) throws Exception;
  }

  static <T,R> Function<T,R> wrap(ExceptionFunction<T,R> f) {
	return (T r) -> {
		try {
			return f.apply(r);
		} catch (Exception re) {
			System.out.println("Exception@wrap:" + re.getMessage());
			throw new RuntimeException(re);
		}
	};
  }

  static class Foo {
    String name;
    List<Bar> bars = new ArrayList<>();

    Foo(String name) {
      this.name = name;
    }

	public List<Bar> getBars() { return this.bars; }

	public static List<Bar> toBars(Foo f) {
//		int idx = 0;

//		var rt = Stream.of(f.name.chars())
//							.map(Character::toUpperCase)
//							.map(c -> new Bar(f.name + "_" + idx++ + "-" + c));
		System.out.println("##### toBars - 1 #####");
		AtomicInteger idx = new AtomicInteger(0);
		return f.name.chars()
			.map(Character::toUpperCase)
//			.map(c-> new Bar(f.name + "_" + idx.getAndIncrement() + "-" + c))
			.mapToObj(c-> new Bar(f.name + "_" + idx.getAndIncrement() + "-" + c))
			.collect(Collectors.toList());
	}
  }

  static class Bar {
    String name;
	String fooName;

    Bar(String name) {
      this.name = name;
    }

	public void setFooName(String fooName) {
		this.fooName = fooName;
	}

	String getName() { return name; }
	public String toString() {
		return String.format("name : %s", name);
	}
  }
	/*
	public static void main(String[] args) {
		var a = Arrays.asList("aa", "bb", "cc");
		List<String> ca = new ArrayList<String>();
		a.stream()
			.map(str -> str.toUpperCase())
			.map(str -> str.chars())
			.flatMap(str -> str.mapToObj(n-> (char)n))
			.forEach(System.out::println);
	}
*/

}
