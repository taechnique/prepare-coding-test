import bfs.BfsTest;
import bit_operator.BitOperation;
import programmers.TestFirstSearch;
import programmers.TestHeap;
import programmers.TestStackAndQueue;
import sort.merge_sort.MergeSort;
import sort.selection_sort.SelectionSort;

public class Main {

    public static void main(String[] args) throws Exception {
//        DynamicProgramming.calfibo();
//        ChargeWithDP.start();
//        DynamicProgramming.practiceDP1();
//        DynamicProgramming.practice1();
//        DynamicProgramming.carryForCargo();
//        Example.deliveryForSugar();
//        Example.saveFailureLate();
//        Practice01.test01();
//        Example.leaveWork();
//        TestHash.phoneNumberList();
//        TestHash.camouflage();
//        TestHash.bestAlbum();
//        int [] needSort = {1, 4, 7, 3, 2, 5};
//        SelectionSort.selectionSort(needSort);
//        BitOperation.dropTheBit();
//        BitOperation.andOperation();
//        BitOperation.orOperation();
//        BitOperation.xOrOperation();
//        BitOperation.notOperation();
//        BitOperation.shiftOperation();
//        TestStackAndQueue.developForFeature();
//        TestStackAndQueue.printer();
//        TestStackAndQueue.truckOnBridge();
//        TestStackAndQueue.priceOfStock();
//        BfsTest.bfsAsList();
//        BfsTest.bfsWithNumber();
//        MergeSort.startMergeSort();
//        TestHeap.moreSpicy();
//        TestHeap.diskController();
//        TestFirstSearch.targetNumber(new int []{1, 1, 1, 1, 1}, 3);
        String [][] optionList = new String[][]{
                {"1","2"},
                {"a", "b", "c"},
                {"가", "나"},
                {"A", "B", "C", "D"}};
        TestFirstSearch.optionTree(optionList);
    }




}
