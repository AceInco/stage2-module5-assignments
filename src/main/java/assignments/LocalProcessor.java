package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private StringBuilder processorName;
    private Long period = 10_000_000_000_000L;
    private StringBuilder processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;

    public LocalProcessor(String processorName, String processorVersion, Integer valueOfCheap) {
        this.processorName = new StringBuilder(processorName);
        this.processorVersion = new StringBuilder(processorVersion);
        this.valueOfCheap = valueOfCheap;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
        for (String string : new LinkedList<>(stringList)) {
            if (string != null) {
                System.out.println(string.hashCode());
            }
        }
    }
    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(LinkedList<String> stringList) {
        for (String string : stringList) {
            processorName.append(string).append(' ');
        }
        return processorName.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        try{
            informationScanner = new Scanner(file);
            while (informationScanner.hasNext()) {
                processorVersion.append(informationScanner.nextLine());
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        } finally {
            if (informationScanner != null){
                informationScanner.close();
            }
        }
    }
}
