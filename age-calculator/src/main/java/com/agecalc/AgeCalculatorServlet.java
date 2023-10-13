package com.agecalc;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AgeCalculatorServlet")
public class AgeCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dobString = request.getParameter("dob");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dob = null;

        try {
            dob = dateFormat.parse(dobString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long currentTimeMillis = System.currentTimeMillis();
        long dobTimeMillis = dob.getTime();
        long ageInMillis = currentTimeMillis - dobTimeMillis;
        int ageInYears = (int) (ageInMillis / (1000L * 60 * 60 * 24 * 365));
        
        System.out.println(dobString);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(ageInYears);
        out.close();
    }
}
