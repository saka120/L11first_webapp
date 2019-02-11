<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">


        <title>おみくじの結果</title>

        </head>


//String[] omikuji_results = {"大吉", "吉", "中吉", "小吉", "末吉", "凶"};

//omikuji_result = omikuji_results[(int)(Math.random() * 6)]




        <c:choose>
            <c:when test="${errors != null}">
                <h1>入力内容にエラーがあります</h1>
                <ul>
                    <c:forEach var="error" items="${errors}">
                        <li><c:out value="${error}" /></li>
                    </c:forEach>
                </ul>
            </c:when>
            <c:otherwise>
              //  <h1>お問い合わせを受け付けました</h1>
                <table border="1">
                    <tbody>
                        <tr>
                          //  <th>氏名</th>
                         //   <td><c:out value="${username}" /></td>

<c:out value="${username}" />さんの運勢は<c:out value="{result}" />です

                     </tr>


                  //          <th>お問い合わせ内容</th>
                  //          <td>
                  //              <pre><c:out value="${content}" /></pre>
                 //          </td>
                 //       </tr>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
    </body>



</html>