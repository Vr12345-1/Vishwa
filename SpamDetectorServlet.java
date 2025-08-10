import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SpamDetectorServlet extends HttpServlet {
    private ModelTrainer modelTrainer;

    @Override
    public void init() throws ServletException {
        modelTrainer = new ModelTrainer();
        // Load dataset and train the model
        // For simplicity, mock training with sample data
        modelTrainer.train("Spam", "win cash prize");
        modelTrainer.train("Ham", "meeting at 10am");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String emailContent = request.getParameter("emailContent");
        String cleanedText = EmailPreprocessor.cleanText(emailContent);
        String prediction = modelTrainer.predict(cleanedText);

        response.setContentType("text/html");
        response.getWriter().write("<h3>Prediction: " + prediction + "</h3>");
    }
}
