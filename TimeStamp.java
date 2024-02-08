package real_estate_digital_signature;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.Color;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDFont;

public class TimeStamp {
    public static void main(String[] args) {
        try {
            // Step 1: 현재 시간을 얻어온다.
            Calendar calendar = Calendar.getInstance();
            String currentTime = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(calendar.getTime());

            // Step 2: PDF에 타임스탬프를 추가하여 새로운 PDF를 생성한다.
            addTimeStampToPDF("src/DS/Example_contract.pdf", "output_Example_contract.pdf", currentTime);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addTimeStampToPDF(String inputPDF, String outputPDF, String currentTime) throws IOException {
        try (PDDocument document = Loader.loadPDF(new File(inputPDF))) {
            PDPage page = document.getPage(0);
            PDRectangle pageSize = page.getMediaBox();

            // 사용자 지정 폰트 로드
            PDFont font = PDType0Font.load(document, new File("src/DS/NanumBarunGothicBold.ttf")); // 폰트 파일 경로 지정

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true)) {
                contentStream.beginText();

                // 폰트 및 폰트 크기 설정
                float fontSize = 36;
                contentStream.setFont(font, fontSize);

                // 타임스탬프 위치 설정 (가운데);
                float textWidth = font.getStringWidth(currentTime) / 1000 * fontSize;
                float startX = (pageSize.getWidth() - textWidth) / 2;
                float startY = pageSize.getHeight() - 30;

                // 글자 색상 설정
                contentStream.setNonStrokingColor(Color.blue);

                contentStream.newLineAtOffset(startX, startY);
                contentStream.showText(currentTime);
                contentStream.endText();
            }

            // 수정된 PDF 저장
            document.save(new File(outputPDF));
            System.out.println("Timestamp added to PDF: " + outputPDF);
        }
    }
}
