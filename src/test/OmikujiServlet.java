package test;


import java.io.IOException;
import java.io.PrintWriter;

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
    //String result  = request.getParameter("result");


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

        String[] omikuji_results = {"大吉", "吉", "中吉", "小吉", "末吉", "凶"};
        request.setAttribute("omikuji_result", omikuji_results[(int)(Math.random() * 6)]);

    }

    // ビューとなるJSPを指定して表示する
   // RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inquiry_result.jsp");
   // rd.forward(request, response);

    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/omikuji_result.jsp");
    rd.forward(request, response);
}






//	        //  キーボードから入力
//	        BufferedReader a = new BufferedReader (new InputStreamReader (
//	        System.in)) ;
//
//
//	     //     System.out.println("おみくじを引きますか？ 【はい→y  / いいえ→ｎ】") ;
//
//	          String name = a.readLine() ;   //入力された文字を name 変数に代入
//
//	          if (name.equals("y")) {
//
//	              System.out.println("名前を入力してください。");
//
//
//
//	          name = a.readLine() ;
//	            System.out.println (name + "さんの  おみくじの結果は ・・・") ;
//
//	            int tera = (int)(Math.random () * 7) ; // 0から6までの乱数を作る
//	            String omikuji  = " "  ;  // おみくじの結果を格納する
//
//
//	            switch  (tera) {
//	              case 0 :
//	                  omikuji = "大吉" ;
//	                  break ;
//
//	              case 1 :
//	                  omikuji = "中吉" ;
//	                  break ;
//
//	              case 2 :
//	                  omikuji = "小吉" ;
//	                  break ;
//
//
//	              case 3 :
//	                  omikuji = "吉" ;
//	                  break ;
//
//
//	              case 4 :
//	                  omikuji = "凶" ;
//	                  break ;
//
//
//	              case 5 :
//	                  omikuji = "大凶" ;
//	                  break ;
//
//
//	           default :
//
//	               System.out.println("入力が正しくありません。") ;
//	               break ;
//
//	            }
//
//	               System.out.println (omikuji + "です") ;
//
//
//	    //        }  else if (name.equals("n")) {
//
//	    //            System.out.println("また次回に引いてくださいね。") ;
//
//	   //         }  else {
//
//	    //            System.out.println ("y か ｎ を入力してください。") ;
//
//	   //            }
//	             }
//	           }
//


//	}

//  }
