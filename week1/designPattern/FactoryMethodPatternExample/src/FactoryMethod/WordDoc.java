package FactoryMethod;

public class WordDoc implements Document{
	@Override
	public void open() {
		System.out.println("Opening the Word Document");
	}
	@Override
	public void close() {
		System.out.println("Closing the Word Document");
	}
	@Override
	public void save() {
		System.out.println("Saving the Word Document");
	}

}
