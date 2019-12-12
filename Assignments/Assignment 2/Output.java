public class Output {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Mac", "Border Terrier", "Ellie");
        Dog dog2 = new Dog("Blue", "Blue Merle", "Freda");
        System.out.println(dog1.getOwnerDetailsAsString());
        System.out.println(dog2.getOwnerDetailsAsString());
        System.out.println();

        DogShowScore event1 = new DogShowScore("Slalom", 3);
        DogShowScore event2 = new DogShowScore("Tricks", 7);
        DogShowScore event3 = new DogShowScore("Agility", 4);
// could these two go in for loops??
        dog1.addScore(event1);
        dog1.addScore(event2);
        dog1.addScore(event3);
        System.out.println(dog1.getName()+ "'s average score is " + dog1.getShowScore());
        System.out.println("They entered " + dog1.getNumberOfEventsEntered() + " events");
        System.out.println("Their best event was " + dog1.getBestEvent() + ", with a score of " + dog1.getBestScore());
        System.out.println();

        event1.setScore(4);
        dog2.addScore(event1);
        event2.setScore(6);
        dog2.addScore(event2);
        event3.setScore(8);
        dog2.addScore(event3);
        System.out.println(dog2.getName()+ "'s average score is " + dog2.getShowScore());
        System.out.println("They entered " + dog2.getNumberOfEventsEntered() + " events");
        System.out.println("Their best event was " + dog2.getBestEvent() + ", with a score of " + dog2.getBestScore());
        System.out.println();
// how do i work out which score is higher? where stored? how to compare??
        System.out.println("The overall winner is  ?????? how tf do i work this out");
    }
}
