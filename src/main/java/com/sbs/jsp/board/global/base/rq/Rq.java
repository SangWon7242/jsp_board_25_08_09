package com.sbs.jsp.board.global.base.rq;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;

public class Rq {
  private final HttpServletRequest req;
  private final HttpServletResponse resp;

  public Rq(HttpServletRequest req, HttpServletResponse resp) {
    this.req = req;
    this.resp = resp;

    try {
      req.setCharacterEncoding("UTF-8"); // 들어오는 데이터를 UTF-8로 해석
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
    resp.setCharacterEncoding("UTF-8"); // 완성된 HTML 결과물의 인코딩을 UTF-8로 하겠다.
    resp.setContentType("text/html; charset=utf-8");
  }

  public int getIntParam(String paramName, int defaultValue) {
    String value = req.getParameter(paramName);
    if (value == null || value.isEmpty()) return defaultValue;

    try {
      return Integer.parseInt(value);
    } catch (NumberFormatException e) {
      return defaultValue;
    }
  }

  public String getParam(String paramName, String defaultValue) {
    String value = req.getParameter(paramName);

    if (value == null || value.isEmpty()) return defaultValue;

    return value;
  }

  public void print(String str) {
    try {
      resp.getWriter().append(str);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void setAttr(String attrName, Object value) {
    req.setAttribute(attrName, value);
  }

  public void view(String path) {
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/" + path + ".jsp");
    // usr/article/list -> /jsp/usr/article/list.jsp

    try {
      requestDispatcher.forward(req, resp);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public String getUri() {
    return req.getRequestURI();
  }

  public String getMethod() {
    // getMethod : HTTP 메서드를 가져온다.
    return req.getMethod();
  }

  public String getActionPath() {
    String[] bits = req.getRequestURI().split("/");
    // /usr/article/list -> ["", "usr", "article", "list"]

    return "/%s/%s/%s".formatted(bits[1], bits[2], bits[3]);
  }

  public long getLongPathValueByIndex(int index, int defaultValue) {
    String value = getPathValueByIndex(index, null);

    if(value == null) return defaultValue;

    try {
      return Long.parseLong(value);
    } catch (NumberFormatException e) {
      return defaultValue;
    }
  }

  private String getPathValueByIndex(int index, String defaultValue) {
    String[] bits = req.getRequestURI().split("/");

    try {
      return bits[4 + index];
    } catch (ArrayIndexOutOfBoundsException e) {
      return defaultValue;
    }
  }
}
