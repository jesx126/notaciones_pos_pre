public class main{
    public static void main(String[] args) {
        alg_post ap = new alg_post();
        ap.ejecutarAlgoritmo();

        alg_pre p = new alg_pre();
        String infixExpression = "2+4/5*(5-3)-5*4";
        String prefixExpression = p.infixToPrefix(infixExpression);
        System.out.println("Expresión infija: " + infixExpression);
        System.out.println("Expresión prefija: " + prefixExpression);
    }
}