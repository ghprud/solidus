import java.io.*;
import java.util.*;

class GiftCard{
    public static ArrayList<String> findThreeValues(Map<String, Integer> mapPrices, Integer giftCardValue){
        ArrayList<String> finalList = new ArrayList<String>();
        StringBuffer firstKeyValue = new StringBuffer("");
        StringBuffer secondKeyValue = new StringBuffer("");
        StringBuffer thirdKeyValue = new StringBuffer("");

        int startPos = 0;
        int endPos = 0;
        int outerPos = 0;

        List<String> alKeys = new ArrayList<String>(mapPrices.keySet());
        Integer min = Integer.MAX_VALUE;

        for (int outerCounter = 0; outerCounter < alKeys.size(); outerCounter++){
            int start = outerCounter + 1;
            int end = alKeys.size() - 1;

            // TODO: move this into a common function. This is being used in both the methods
            while (start < end){
                int sum = mapPrices.get(alKeys.get(start)) + 
                    mapPrices.get(alKeys.get(end)) + mapPrices.get(alKeys.get(outerCounter));
                
                int diff = Math.abs(sum - giftCardValue);

                if (diff < min){
                    min = diff;
                    outerPos = outerCounter;
                    startPos = start;
                    endPos = end;
                }

                if (sum > giftCardValue){
                    end--;
                }else{
                    start++;
                }
        }
    }
        System.out.println("startPos: " + startPos);
        System.out.println("endPos: " + endPos);
        System.out.println("outerPos: " + outerPos);
        if (mapPrices.get(alKeys.get(startPos)) 
            + mapPrices.get(alKeys.get(endPos)) 
            + mapPrices.get(alKeys.get(outerPos)) <= giftCardValue){
            firstKeyValue.append(alKeys.get(startPos)).append("-->").append(mapPrices.get(alKeys.get(startPos)));
            finalList.add(firstKeyValue.toString());

            secondKeyValue.append(alKeys.get(endPos)).append("-->").append(mapPrices.get(alKeys.get(endPos)));
            finalList.add(secondKeyValue.toString());

            thirdKeyValue.append(alKeys.get(outerPos)).append("-->").append(mapPrices.get(alKeys.get(outerPos)));
            finalList.add(thirdKeyValue.toString());
        }
        return finalList;
    }
    public static ArrayList<String> findPair(Map<String, Integer> mapPrices, Integer giftCardValue){
        StringBuffer firstKeyValue = new StringBuffer("");
        StringBuffer secondKeyValue = new StringBuffer("");
        ArrayList<String> finalPair = new ArrayList<String>();

        int startPos = 0;
        int endPos = 0;

        // convert to ArrayList of key set
        List<String> alKeys = new ArrayList<String>(mapPrices.keySet());

        System.out.println("array List:" + alKeys.toString());

        int start = 0;
        int end = alKeys.size() - 1 ;
        Integer diff = Integer.MAX_VALUE;
        while (start < end){
            
            if((Math.abs(mapPrices.get(alKeys.get(start)) 
                +  mapPrices.get(alKeys.get(end))) - giftCardValue) < diff){
                startPos = start;
                endPos = end;

                diff = Math.abs(mapPrices.get(alKeys.get(start)) 
                +  mapPrices.get(alKeys.get(end)) - giftCardValue);
            }
            
            if (mapPrices.get(alKeys.get(start)) 
                +  mapPrices.get(alKeys.get(end)) > giftCardValue){
                end--;
            }else{
                start++;
            }
        }
        System.out.println("startPos: " + startPos);
        System.out.println("endPos: " + endPos);
        if (mapPrices.get(alKeys.get(startPos)) + mapPrices.get(alKeys.get(endPos)) <= giftCardValue){
            firstKeyValue.append(alKeys.get(startPos)).append("-->").append(mapPrices.get(alKeys.get(startPos)));
            finalPair.add(firstKeyValue.toString());

            secondKeyValue.append(alKeys.get(endPos)).append("-->").append(mapPrices.get(alKeys.get(endPos)));
            finalPair.add(secondKeyValue.toString());
        }
        
        return finalPair;
    }

    public static LinkedHashMap<String, Integer> getPricesMap(String fileName){
        LinkedHashMap<String, Integer> mapPrices = new LinkedHashMap<String, Integer>();
        
        // What if? 
            // there is no unique identifier 
                //skip this line altogether.
            // there is no price for the identifier
                //skip this line too
            // there are spaces for the price column (use a trim())

        BufferedReader objReader = null;
        try {
            String strCurrentLine;
            objReader = new BufferedReader(new FileReader(fileName));

            while ((strCurrentLine = objReader.readLine()) != null) {
                String splitString[] = strCurrentLine.split(",");
                if (splitString[0].trim().equals("") || splitString[0].trim().length() == 0
                    || splitString[1].trim().equals("") || splitString[0].trim().length() == 0){
                    continue;
                }else{
                    mapPrices.put(splitString[0], Integer.parseInt(splitString[1].trim()));
                }
                System.out.println(strCurrentLine);
            }         
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objReader != null)
                objReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return mapPrices;
    }


    public static void main(String []args){
        // pre-process the and save the data into a hash map
        // The prices are already in sorted order. 
        // find a pair closest or equal the gift card amount
        // the pair has to be less than the value on the gift card

        Map<String, Integer> mapPrices = null;
        System.out.println(args.length);
        String fileName = null;
        Integer giftCardValue = Integer.valueOf(0);
        ArrayList<String> finalPair = null;
        ArrayList<String> finalList = null;

        if (args.length != 2){
            System.out.println("usage GiftCard <file_name> <gift_card_value>");
        }else{
            fileName = args[0];
            giftCardValue = Integer.parseInt(args[1]);

            mapPrices = getPricesMap(fileName);

            System.out.println("giftCard Value: " + giftCardValue);

            finalPair = findPair(mapPrices, giftCardValue);

            finalList = findThreeValues(mapPrices, giftCardValue);
        }
        System.out.println(finalPair.size() == 0 ? "not possible" : finalPair.toString());
        System.out.println(finalList.size() == 0 ? "not possible" : finalList.toString());
    }
}