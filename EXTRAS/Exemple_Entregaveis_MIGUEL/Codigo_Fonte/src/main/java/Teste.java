import implementation.controller.Test;
import implementation.models.QuestionMultipleChoice;
import interfaces.controller.ITest;
import interfaces.exceptions.TestException;
import views.TestWindow;

public class Teste {

        public static void main(String[] args) throws TestException {


            ITest demoTest;
            demoTest = new implementation.controller.Test();
            demoTest.loadFromJSONFile("data/teste_A.json");

            QuestionMultipleChoice qmc = (QuestionMultipleChoice) demoTest.getQuestion(0);

            qmc.setUser_answer("Encapsulation");

            qmc.evaluateAnswer();

            //assertEquals(false,qmc.evaluateAnswer());

            /*            System.out.println("Inicio de Teste!");
            ITest demoTest = new Test();
            demoTest.loadFromJSONFile("data/teste_A.json");
            TestWindow t = new TestWindow();
            t.startTest(demoTest);
            System.out.println("Teste Efectuado!");
            System.out.println(demoTest.toString());*/

        }


}

