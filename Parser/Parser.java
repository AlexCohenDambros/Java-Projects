// Grupo:
// Alex Cohen Dambrós Lopes
// Carlos Henrique Moreira dos Santos
// Gabriel Scholze Rosa
// João Vitor Brandão
// Manoel Felipe de Almeida Bina
// Matheus Leindorf Muller
package Parser;

public class Parser {
    public boolean Formula(String formula) {
        if(Constante(formula) || Proposicao(formula) || FormulaUnaria(formula) || FormulaBinaria(formula)) {
            return true;
        }
        return false;
    }

    public boolean Constante(String formula) {
        if (formula.equals("T") || formula.equals("F")) {
            return true;
        }
        return false;
    }

    public boolean Proposicao(String formula) {
        if(formula.length() != 1) {
            return false;
        }
        String alfaNumerico = "abcdefghijklmnopqrstuvwxyz"
                + "0123456789";
        for(int i = 0; i < alfaNumerico.length();i++) {
            if(alfaNumerico.charAt(i) == formula.charAt(0)) {
                return true;
            }
        }
        return false;
    }

    public boolean FormulaUnaria(String formula) {
        if(formula.length() < 4) {
            return false;
        }
        char abreParenteses = formula.charAt(0);
        char operator = formula.charAt(1);
        String palavra = "";
        int i = 2;
        while(i != formula.length()-1) {
            palavra += formula.charAt(i);
            i++;
        }
        char fechaParenteses = formula.charAt(i);

        if(AbreParen(abreParenteses) && OperatorUnario(operator) && Formula(palavra) && FechaParen(fechaParenteses)) {
            return true;
        }
        return false;
    }

    public boolean FormulaBinaria(String formula) {
        if(formula.length() < 5) {
            return false;
        }
        char abreParenteses = formula.charAt(0);
        char operator = formula.charAt(1);
        String palavra = "";
        String palavra2 = "";
        int x = 0;
        int y = 0;
        for(int i = 2;i != formula.length()-1; i++) {
            if(formula.charAt(i-1) == ')' && x == 0) {
                while(i != formula.length()-1) {
                    palavra2 += formula.charAt(i);
                    i++;
                }
                y = i;
                break;
            }else if(formula.charAt(i) == '(') {
                x++;
            }else if(formula.charAt(i) == ')') {
                x--;
            }
            palavra += formula.charAt(i);
        }
        char fechaParenteses = formula.charAt(y);

        if(AbreParen(abreParenteses) && OperatorBinario(operator) && Formula(palavra) && Formula(palavra2) && FechaParen(fechaParenteses)) {
            return true;
        }
        return false;
    }

    public boolean AbreParen(char parenteses) {
        if(parenteses == '(') {
            return true;
        }
        return false;
    }

    public boolean FechaParen(char parenteses) {
        if(parenteses == ')') {
            return true;
        }
        return false;
    }

    public boolean OperatorUnario(char operator) {
        if(operator == '¬') {
            return true;
        }
        return false;
    }

    public boolean OperatorBinario(char operator) {
        if(operator == '∨' || operator == '∧' || operator == '→' || operator == '↔') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Parser p = new Parser();

        System.out.println(p.Formula("(¬P)"));
    }
}