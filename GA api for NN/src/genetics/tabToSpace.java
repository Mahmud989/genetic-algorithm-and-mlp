/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetics;

/**
 *
 * @author Mahmud
 */
public class tabToSpace {
public static void main(String[] args){
	String text = "/*\n" +
" * To change this license header, choose License Headers in Project Properties.\n" +
" * To change this template file, choose Tools | Templates\n" +
" * and open the template in the editor.\n" +
" */\n" +
"package ga.api.pkgfor.seller;\n" +
"\n" +
"import data.Cities;\n" +
"import data.City;\n" +
"import Constant.Condition;\n" +
"import Constant.Const;\n" +
"import Constant.Range;\n" +
"import genetics.Chromosome;\n" +
"import genetics.Population;\n" +
"\n" +
"/**\n" +
" *\n" +
" * @author Mahmud\n" +
" */\n" +
"public class GAApiForSeller {\n" +
"\n" +
"    static Cities cities = new Cities(5);\n" +
"\n" +
"    public static void main(String[] args) {\n" +
"        cities.append(new City(\"A\", new double[]{Double.MAX_VALUE, 23, 40, 60, 40, 4}, 0));\n" +
"\n" +
"        cities.append(new City(\"B\", new double[]{23, Double.MAX_VALUE, 12, 30, 60, 8}, 1));\n" +
"\n" +
"        cities.append(new City(\"C\", new double[]{40, 12, Double.MAX_VALUE, 14, 20, 20}, 2));\n" +
"\n" +
"        cities.append(new City(\"D\", new double[]{60, 30, 14, Double.MAX_VALUE, 13, 23}, 3));\n" +
"\n" +
"        cities.append(new City(\"E\", new double[]{40, 60, 20, 13, Double.MAX_VALUE, 5}, 4));\n" +
"\n" +
"        cities.append(new City(\"F\", new double[]{4, 8, 20, 23, 5, Double.MAX_VALUE}, 5));\n" +
"//tour : c-a-b-f-e-d\n" +
"//length  : 76.0\n" +
"        int directionn[] = new int[]{0, 5, 4, 3, 2, 1};\n" +
"        System.out.println(cities.compute(directionn));\n" +
"        Const.setFunction((Double... x) -> {\n" +
"            var direction = new int[x.length];\n" +
"            for (int i = 0; i < direction.length; i++) {\n" +
"                direction[i] = (int) x[i].doubleValue();\n" +
"            }\n" +
"            return cities.compute(direction);\n" +
"        });\n" +
"\n" +
"        Const.setConditions(new Condition<Double>() {\n" +
"            @Override\n" +
"            public Boolean compute(Double... x) {\n" +
"                for (int i = 0; i < x.length; i++) {\n" +
"                    for (int j = 0; j < x.length; j++) {\n" +
"                        if (i != j && x[j].equals(x[i])) {\n" +
"                            return false;\n" +
"                        }\n" +
"                    }\n" +
"                }\n" +
"                return true;\n" +
"            }\n" +
"        });\n" +
"        Const.setSearch(Const.MIN);\n" +
"        Const.setTYPE_DATA(Const.INT_DATA);\n" +
"        Const.setTYPE_PR(Const.UNIQUE_PR);\n" +
"        Const.setRanges(new Range[]{\n" +
"            new Range(0, cities.getSize() - 1)\n" +
"        });\n" +
"        Const.setVar_count(cities.getSize());\n" +
"        Population p = new Population();\n" +
"        int generation = 1;\n" +
"        long time = System.currentTimeMillis();\n" +
"        while (generation < 400_000) {\n" +
"            if (2 * generation % 3 == 0) {\n" +
"                p.mutate();\n" +
"            }\n" +
"            p.computeAllChromosomeValue();\n" +
"            p.crossOver();\n" +
"            p.createNewGeneration();\n" +
"            p.printOptimalChromosome();\n" +
"            System.out.println(\"---------------------------------------------------------------\");\n" +
"            Chromosome chromosome = p.chromosomes[p.getMinChromosome()];\n" +
"            if (generation % 10 == 0) {\n" +
"                System.out.printf(\"%d optimal chromosome  = %.20f \\n\", generation, chromosome.getOverAll());\n" +
"            }\n" +
"            if (System.currentTimeMillis() - time >= 40 * 1000) {\n" +
"                System.err.println(generation + \"-------breaak \" + (double) (System.currentTimeMillis() - time) / 1000 + \" sec\");\n" +
"                break;\n" +
"            }\n" +
"            generation++;\n" +
"        }\n" +
"        System.out.println(\"\\n-------------\");\n" +
"        Chromosome chromosome = p.chromosomes[p.getMinChromosome()];\n" +
"        double[] rotation = chromosome.getElements();//p.getOptimalChromosome();\n" +
"        String ist = \"\";\n" +
"        for (double double1 : rotation) {\n" +
"            ist += cities.getCity((int) double1).getName() + \"-\";\n" +
"        }\n" +
"        System.out.println(\"route : \" + ist.substring(0, ist.length() - 1));\n" +
"        System.out.println(\"length  : \" + chromosome.getOverAll());\n" +
"\n" +
"    }\n" +
"}\n" +
"";
	System.out.println(text.replaceAll("\t", " "));
}
	
}
