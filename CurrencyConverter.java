import model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class CurrencyConverter extends HttpServlet {
  
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    
	  String code1 = "0",code2 = "0";
	  resp.setContentType("text/html");
	  PrintWriter out = resp.getWriter();
	  out.println("Selections made </br>");
	  String c1 = req.getParameter("CurItIs");
	  String c2 = req.getParameter("CurToBe");
	  String valu = req.getParameter("inpt");
    
	  if (c1.equals("USD")){code1 = "USD";}
	  if (c1.equals("GBP")){code1 = "GBP";}
	  if (c1.equals("Pesos")){code1 = "MXN";}
	  if (c1.equals("Yen")) {code1 = "JPY";}
	  if (c1.equals("Euros")) {code1 = "EUR";}
	  
	  if (c2.equals("USD")){code2 = "USD";}
	  if (c2.equals("GBP")){code2 = "GBP";}
	  if (c2.equals("Pesos")){code2 = "MXN";}
	  if (c2.equals("Yen")) {code2 = "JPY";}
	  if (c2.equals("Euros")) {code2 = "EUR";}
	  
	  
	  MainConversion co = new MainConversion();
	  double total = co.doConversion(code1, code2, valu);
    
	  if (total == -1) {
		  out.println("Error! Wrong input");
	  }
	  else if (total == -2) {
		  out.println("Url Error!!");
	  }
	  else {
		  out.println("Selected for conversion: " + c1);
		  out.println("</br>Selected to convert to: " +c2);
		  out.println("</br>Result: " + total);
		  out.println(" " + c2);
	  }
  }
}
