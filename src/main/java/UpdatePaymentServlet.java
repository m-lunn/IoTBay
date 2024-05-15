import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updatePayment")
public class UpdatePaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the form data
        String paymentId = request.getParameter("paymentId");
        String cardNumber = request.getParameter("cardNumber");
        String expiryDate = request.getParameter("expiryDate");
        String cvv = request.getParameter("cvv");
        String nameOnCard = request.getParameter("nameOnCard");

        // Perform database operations to update the payment method
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Establish the database connection
            Class.forName("your-database-driver-class");
            conn = DriverManager.getConnection("your-database-connection-url", "username", "password");

            // Prepare the SQL statement
            String sql = "UPDATE payment_table SET card_number = ?, expiry_date = ?, cvv = ?, name_on_card = ? WHERE payment_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cardNumber);
            stmt.setString(2, expiryDate);
            stmt.setString(3, cvv);
            stmt.setString(4, nameOnCard);
            stmt.setString(5, paymentId);

            // Execute the update statement
            int rowsUpdated = stmt.executeUpdate();

            // Check the number of rows affected
            if (rowsUpdated > 0) {
                response.getWriter().println("Payment method updated successfully.");
            } else {
                response.getWriter().println("Failed to update the payment method.");
            }
        } catch (Exception e) {
            response.getWriter().println("An error occurred: " + e.getMessage());
        } finally {
            // Close the database resources
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}