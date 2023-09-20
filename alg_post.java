import java.util.Stack;

public class alg_post{
    public void ejecutarAlgoritmo(){
        Stack<Character> pilaPost = new Stack<>();
            String expresion="2+4/5*(5-3)-5*4";
            String postfix="";
            int longitud = expresion.length();
            for(int i=0;i<longitud;i++){
                if(expresion.charAt(i)>=48 && expresion.charAt(i)<=57){
                    postfix+=expresion.charAt(i);
                }else if(pilaPost.empty()||expresion.charAt(i)==40){
                    pilaPost.push(expresion.charAt(i));
                }else{
                    if(expresion.charAt(i)==41){
                                while(!pilaPost.isEmpty()){
                                if(pilaPost.peek()!=40){
                                    postfix+=pilaPost.pop();
                                }else{
                                    pilaPost.pop();
                                }
                    }
                            }
                    switch(expresion.charAt(i)){
                        case '*':
                        case '/':
                            if(pilaPost.peek()==42 || pilaPost.peek()==47 ){
                                postfix+=pilaPost.pop();
                                pilaPost.push(expresion.charAt(i));
                            }else{
                                pilaPost.push(expresion.charAt(i));
                            }
                            break;
                        case '+':
                        case '-':
                            if(pilaPost.peek()==43 || pilaPost.peek()==45 ){
                                postfix+=pilaPost.pop();
                                pilaPost.push(expresion.charAt(i));
                            }else if(pilaPost.peek()==40){
                                pilaPost.push(expresion.charAt(i));
                            }else{
                                while(!pilaPost.isEmpty()){
                                    if(pilaPost.peek()!=40){
                                        postfix+=pilaPost.pop();
                                    }else{
                                        pilaPost.pop();
                                    }
                                }
                                pilaPost.push(expresion.charAt(i));
                            }
                            break;
                    }
                }
            }
            while(!pilaPost.isEmpty()){
                if(pilaPost.peek()!=40){
                    postfix+=pilaPost.pop();
                }else{
                    pilaPost.pop();
                }
            }
            System.out.println("La notación postfija de la expresion: "+expresion+"\nes: "+postfix);
    }

}