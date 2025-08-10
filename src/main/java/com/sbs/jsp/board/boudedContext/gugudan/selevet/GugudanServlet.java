package com.sbs.jsp.board.boudedContext.gugudan.selevet;

import com.sbs.jsp.board.global.base.rq.Rq;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Rq rq = new Rq(req, resp);

    int dan = rq.getIntParam("dan", 9);
    int limit = rq.getIntParam("limit", 9);

    // setAttribute : key, value 쌍으로 데이터를 저장
    req.setAttribute("dan", dan);
    req.setAttribute("limit", limit);
    req.setAttribute("age", 25); // age : key, 20 : value

    // forward : 요청을 다른 JSP로 넘김
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/gugudan2.jsp");
    requestDispatcher.forward(req, resp);

  }
}
