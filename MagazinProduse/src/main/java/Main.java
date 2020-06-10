import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // Sa se citeasca dintr-un fisier produsele aflate la vanzare dintr-un magazin.
        // Pe fiecare rand com avea categoria (alimentare, curatenie,auto), numele, raionul, oretul si discount-ul
        // Sa se grupeze produsele in colectii separate in functie de categorie, in functie de pret: <100RON, <50RON, >100LEI, in functie de reducere (<10,% >25% 30%)
        // Sa se scrie produsele in functie de colectia din care fac parte in fisiere separate.


        try {
            String filePath = "D:\\Java Projects\\Files for use in exercises\\MagazinAlimentar\\fisierProduse.txt";
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String readLine = bufferedReader.readLine();
            Map<String, ArrayList<Product>> productCategoryMap = new HashMap<String, ArrayList<Product>>();
            Map<String, ArrayList<Product>> productPriceMap = new HashMap<String, ArrayList<Product>>();
            Map<String, ArrayList<Product>> productDiscountMap = new HashMap<String, ArrayList<Product>>();


            // Creem map-uri in functie de fiecare categorie de alimente dupa care dorim sa sortam (categorie = pret)
            productCategoryMap.put("Alimentare", new ArrayList<Product>());
            productCategoryMap.put("Curatenie", new ArrayList<Product>());
            productCategoryMap.put("Auto", new ArrayList<Product>());

            // Creem map-uri in functie de pret (cheie = pret):
            productPriceMap.put("<100RON", new ArrayList<Product>());
            productPriceMap.put("<50RON", new ArrayList<Product>());
            productPriceMap.put(">100RON", new ArrayList<Product>());

            // Creem map-uri cu cheie reducere
            productDiscountMap.put("10", new ArrayList<Product>());
            productDiscountMap.put("25", new ArrayList<Product>());
            productDiscountMap.put("30", new ArrayList<Product>());

            while (readLine != null) {

                // Impartim liniile de text in array-uri cu elemente separate de ";"
                String[] lineArray = readLine.split(";");

                // Instanteiem obiecte de tip Product cu elementele Array-ului creat anterior
                Product product = new Product(lineArray[0], lineArray[1], lineArray[2], lineArray[3], lineArray[4]);

                // Filtram liniile din fisier in functie de categoria de alimente
                if (product.getCategory().equals("Alimentare")) {
                    productCategoryMap.get("Alimentare").add(product);
                } else if (product.getCategory().equals("Curatenie")) {
                    productCategoryMap.get("Curatenie").add(product);
                } else if (product.getCategory().equals("Auto")) {
                    productCategoryMap.get("Auto").add(product);
                }

                // Filtram liniile din fisier in functie de pret
                if (Integer.valueOf(product.getPrice()) < 100) {
                    productPriceMap.get("<100RON").add(product);
                } else if (Integer.valueOf(product.getPrice()) < 50) {
                    productPriceMap.get("<50RON").add(product);
                } else  if(Integer.valueOf(product.getPrice()) > 100){
                    productPriceMap.get(">100RON").add(product);
                }

                // Filtram liniile din fisier in functie de discount
                if (product.getDiscount().equals("10")) {
                    productDiscountMap.get("10").add(product);
                } else if (product.getDiscount().equals("25")) {
                    productDiscountMap.get("25").add(product);
                } else if (product.getDiscount().equals("30")) {
                    productDiscountMap.get("30").add(product);
                }
                readLine = bufferedReader.readLine();

                String categoryFilePath = "D:\\Java Projects\\Files for use in exercises\\MagazinAlimentar\\fisierCategorii.txt";
                String priceFilePath = "D:\\Java Projects\\Files for use in exercises\\MagazinAlimentar\\fisierPret.txt";
                String discountFilePath = "D:\\Java Projects\\Files for use in exercises\\MagazinAlimentar\\fisierDiscount.txt";

                FileWriter fileCategoryWriter = new FileWriter(categoryFilePath);
                BufferedWriter categoryWrite = new BufferedWriter((fileCategoryWriter));

                FileWriter filePriceWriter = new FileWriter(priceFilePath);
                BufferedWriter priceWriter = new BufferedWriter(filePriceWriter);

                FileWriter fileDiscountWriter = new FileWriter(discountFilePath);
                BufferedWriter discountWriter = new BufferedWriter(fileDiscountWriter);

                // Transformam map-urile cu categoriile de produse in  ArrayList-uri si le scriem in fisierul corespunzator
                ArrayList<Product> foodProducts = productCategoryMap.get("Alimentare");
                for (Product foodProduct : foodProducts) {
                    categoryWrite.write(foodProduct.toString());
                    categoryWrite.newLine();
                }

                ArrayList<Product> cleaningProducts = productCategoryMap.get("Curatenie");
                for (Product cleaningProduct : cleaningProducts) {
                    categoryWrite.write(cleaningProduct.toString());
                    categoryWrite.newLine();
                }

                ArrayList<Product> autoProducts = productCategoryMap.get("Auto");
                for (Product autoProduct : autoProducts) {
                    categoryWrite.write(autoProduct.toString());
                    categoryWrite.newLine();
                }

                categoryWrite.flush();
                categoryWrite.close();


                // Transformam map-urile cu preturile de produse in  ArrayList-uri si le scriem in fisierul corespunzator

                ArrayList<Product> lower100products = productPriceMap.get("<100RON");
                for(Product lower100product: lower100products){
                    priceWriter.write(lower100product.toString());
                    priceWriter.newLine();
                }

                ArrayList<Product> lower50products = productPriceMap.get("<50RON");
                for(Product lower50product: lower50products){
                    priceWriter.write(lower50product.toString());
                    priceWriter.newLine();
                }

                ArrayList<Product> higher100products = productPriceMap.get(">100RON");
                for(Product higher100product: higher100products){
                    priceWriter.write(higher100product.toString() );
                }

                priceWriter.flush();
                priceWriter.close();

                // Transformam map-urile cu discounturile de produse in  ArrayList-uri si le scriem in fisierul corespunzator

                ArrayList<Product> discount10products = productDiscountMap.get("10");
                for(Product discount10product: discount10products){
                    discountWriter.write(discount10product.toString());
                    discountWriter.newLine();
                }

                ArrayList<Product> discount25products = productDiscountMap.get("25");
                for(Product discount25product: discount25products){
                    discountWriter.write(discount25product.toString());
                    discountWriter.newLine();
                }

                ArrayList<Product> discount30products = productDiscountMap.get("30");
                for(Product discount30product: discount30products){
                    discountWriter.write(discount30product.toString());
                    discountWriter.newLine();
                }
                discountWriter.flush();
                discountWriter.close();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fisier negasit: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Exceptie IO: " + e.getMessage());
        }
    }
}
