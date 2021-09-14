// A Simple Java program
// to show working of user defined
// Generic classes

// We use < > to specify Parameter type
class Generics<T, V> {

	// An object of type T is declared
	public T obj;
	public V val;

	// constructor
	public Generics(T obj, V val) {
		this.obj = obj;
		this.val = val;
	}

	public T getObjectT() {
		return this.obj;
	}

	public V getObjectV() {
		return this.val;
	}
}
