package FactoryMethod;

public class PdfDoc implements Document{
	@Override
	public void open() {
		System.out.println("Opening the PDF Document");
	}
	@Override
	public void close() {
		System.out.println("Closing the PDF Document");
	}
	@Override
	public void save() {
		System.out.println("Saving the PDF Document");
	}

}
