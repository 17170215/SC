package SalaryCalc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryCalcTest {

    private SalaryCalc testingClass;

    void setUp() {
        testingClass = new SalaryCalc();
    }

    void tearDown() {
        testingClass = null;
    }

    void calcSalary1() throws Exception {
        testingClass.arrTf[1].setText("228");
        testingClass.arrTf[2].setText("5");
        testingClass.arrTf[3].setText("13");
        testingClass.arrTf[4].setText("37");
        testingClass.calcSalary();
        assertEquals("10270,26", testingClass.arrTf[9].getText());
    }
    
    void calcSalary2() throws Exception {
        testingClass.arrTf[1].setText("133");
        testingClass.arrTf[2].setText("7");
        testingClass.arrTf[3].setText("14");
        testingClass.arrTf[4].setText("88");
        testingClass.calcSalary();
        assertEquals("1720,49", testingClass.arrTf[9].getText());
}

	private void assertEquals(String string, String text) {
		// TODO Auto-generated method stub
		
	} 
}