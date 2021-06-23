package utilities;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import org.apache.pdfbox.util.Matrix;

import reports.IReport;

public final class PDFExporter {
	private PDFExporter() {
	}

	public static void generatePDF(IReport report) throws IOException {

		String capturedString = captureString(report);

		ArrayList<String> lines = filtrString(capturedString);

		String filename = "Nazwa_pliku_przykladowa.pdf";

		try (PDDocument doc = new PDDocument()) {
			PDPage page = new PDPage();
			doc.addPage(page);
			page.setRotation(90);

			PDType0Font font = PDType0Font.load(doc, new File("../report-management-system/resources/cour.ttf"));

			try (PDPageContentStream contents = new PDPageContentStream(doc, page)) {

				contents.transform(new Matrix(0, 1, -1, 0, 0, 0));

				contents.beginText();
				contents.setFont(font, 10);
				contents.newLineAtOffset(40, -40);
				
				contents.showText("© Super raport do generowania statystyk w Twojej firmie!");
				
				contents.newLineAtOffset(0, -25);
				
				for (String s : lines) {

					contents.showText(s);

					contents.newLineAtOffset(0, -16);

				}
				

				contents.endText();
			}

			doc.save(filename);
		}
	}

	private static String captureString(IReport report) {

		PrintStream standardOut = System.out;
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStreamCaptor));

		report.printReport();

		System.setOut(standardOut);

		String capturedString = outputStreamCaptor.toString();

		return capturedString;
	}

	private static ArrayList<String> filtrString(String input) {
		ArrayList<String> lines = new ArrayList<String>();

		String nl = "\n";

		String rc = "\r";

		String[] tempStash = { "temp", input };

		int positionN;

		int positionR;

		String splitter;

		while (tempStash.length > 1) {

			while (tempStash[1].indexOf(nl) == 0 || tempStash[1].indexOf(rc) == 0) {
				tempStash[1] = tempStash[1].substring(1, tempStash[1].length());
			}

			positionN = tempStash[1].indexOf(nl);

			positionR = tempStash[1].indexOf(rc);

			splitter = positionN < positionR ? nl : rc;

			tempStash = tempStash[1].split(splitter, 2);

			while (tempStash[0].endsWith(nl) || tempStash[0].endsWith(rc)) {
				tempStash[0] = tempStash[0].substring(0, tempStash[0].length() - 1);
			}

			lines.add(tempStash[0]);

		}

		return lines;
	}

}