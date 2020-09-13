package com.company;

import java.io.File;
import java.io.PrintStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        csvSorter();
        mathCalculations();
        apiCall();

    }

    public static void csvSorter() throws Exception {
        Scanner sc = new Scanner(new File("input1.txt"));
        PrintStream ps = new PrintStream(new File("output1.txt"));
        //while loop to read each line in the file and sort the strings by alphabetical order
        while (sc.hasNextLine()) {
            String fileLine = sc.nextLine();
            String[] newArr = fileLine.split(",");
            Arrays.sort(newArr);
            ps.println(String.join(" ", newArr));
        }
    }

    public static void mathCalculations() throws Exception {
        Scanner sc = new Scanner((new File("input2.txt")));
        PrintStream ps = new PrintStream(new File("output2.txt"));
        //while loop to loop through the file and convert each number found
        while (sc.hasNextInt()) {
            int tempFahrenheit = sc.nextInt();
            int tempCelsius = Math.round((((tempFahrenheit - 32) * 5) / 9));
            ps.println(tempFahrenheit + "F = " + tempCelsius + "C");
        }
    }

    public static void apiCall() throws Exception {
        PrintStream ps = new PrintStream(new File("output3.txt"));
        var url = "https://api.nasa.gov/planetary/apod?api_key=93Zeimi1q0mEg9ufXbKBqUdnyQbd5xLulwZW31S2";
        var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        var client = HttpClient.newBuilder().build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ps.println(response.statusCode());
        ps.println(response.body());


    }

}



