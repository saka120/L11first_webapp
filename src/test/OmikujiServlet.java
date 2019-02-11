package test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet("/HelloServlet")
@WebServlet("/OmikujiServlet")

public class OmikujiServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OmikujiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    /*
     *
     * (非 Javadoc)
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // リクエストパラメータを取得する
    String username = request.getParameter("username");

    //String usermail = request.getParameter("usermail");
    //String content  = request.getParameter("content");

    String result  = request.getParameter("result");


    // 入力項目チェック（バリデーション）
    List<String> errors = new ArrayList<String>();

    if(username == null || username.equals("")) {  /* 氏名 */
        errors.add("氏名を入力してください");
    }



    // 入力内容にエラーがあったかどうか
    if(errors.size() > 0) {
        // JSPにエラー内容を送る
        request.setAttribute("errors", errors);
    } else {
        // JSPに入力データを送る
        request.setAttribute("username", username);

      //  request.setAttribute("usermail", usermail);
      //  request.setAttribute("content", content);

        String[] results = {"大吉", "吉", "中吉", "小吉", "末吉", "凶"};
        request.setAttribute("result", results[(int)(Math.random() * 6)]);

    }

    // ビューとなるJSPを指定して表示する
   // RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inquiry_result.jsp");
   // rd.forward(request, response);

    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/omikuji_result.jsp");
    rd.forward(request, response);
}
}


