package utilities;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import org.apache.pdfbox.util.Matrix;

import reports.IReport;

public final class PDFExporter {

	private static Scanner scanner = new Scanner(System.in);

	private static String teamName = "©DreamTeam";

	private PDFExporter() {
	}

	public static void generatePDF(IReport report) throws IOException {

		String capturedString = captureString(report);
		ArrayList<String> lines = filtrString(capturedString);

		String defaultFilename = report.getReportName() + ".pdf";

		System.out.println(
				"Podaj nazwę pliku lub pozostaw puste aby użyć domyślnej nazwy i naciśnij enter (domyślna nazwa: "
						+ defaultFilename + ")");
		String filename = scanner.nextLine() + ".pdf";

		if (filename.equals(".pdf")) {
			filename = defaultFilename;
		}
		
		scanner.close();
		
		PDPage page = new PDPage();
		PDDocument doc = new PDDocument();

		PDType0Font font = PDType0Font.load(doc, new File("../report-management-system/resources/cour.ttf"));

		int pageHeight = (int) page.getMediaBox().getWidth();

		int fontSize = 12;

		int xMargin = 40;

		int yStartPosition = -40;
		int yFirstLineOffset = (int) -2.5 * fontSize;
		int yNewLineOffset = (int) -1.6 * fontSize;

		int yInitialCarriagePosition = yStartPosition + yFirstLineOffset;
		int yCarriagePosition = yInitialCarriagePosition;

		int pageNumber = 1;

		String firstLine = lines.get(0);

		lines.remove(0);

		while (!lines.isEmpty()) {

			page = new PDPage();

			PDPageContentStream contents = new PDPageContentStream(doc, page);

			page.setRotation(90);

			contents.setFont(font, fontSize);

			contents.transform(new Matrix(0, 1, -1, 0, 0, 0));

			contents.beginText();

			contents.newLineAtOffset(xMargin, yStartPosition);

			contents.showText("Super raport do generowania statystyk w Twojej firmie!");

			contents.newLineAtOffset(0, yFirstLineOffset);

			contents.showText(firstLine);

			contents.newLineAtOffset(0, yFirstLineOffset);

			for (int i = 0; i < lines.size(); i++) {

				while (Math.abs(yCarriagePosition) < pageHeight + yStartPosition * 2 && lines.size() > 0) {

					contents.showText(lines.get(0));

					lines.remove(0);

					contents.newLineAtOffset(0, yNewLineOffset);

					yCarriagePosition = yCarriagePosition + yNewLineOffset;

				}

			}

			while (Math.abs(yCarriagePosition) < pageHeight + yStartPosition) {
				contents.newLineAtOffset(0, yNewLineOffset);
				yCarriagePosition = yCarriagePosition + yNewLineOffset;
			}

			String pageNo = "Page " + pageNumber + " --- " + teamName;

			contents.setFont(font, fontSize - 4);
			contents.showText(pageNo);
			yCarriagePosition = yInitialCarriagePosition;
			contents.endText();
			contents.close();
			doc.addPage(page);
			pageNumber++;

		}

		doc.save(filename);
		doc.close();
		System.out.println("PDF created");
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