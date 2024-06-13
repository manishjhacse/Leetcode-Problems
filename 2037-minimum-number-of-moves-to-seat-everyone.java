class Solution {
    public int minMovesToSeat(int[] seatPositions, int[] studentPositions) {
        Arrays.sort(seatPositions);
        Arrays.sort(studentPositions);
        int numberOfSeats = seatPositions.length;
        int totalMoves = 0;
        for (int i = 0; i < numberOfSeats; i++) {
            totalMoves += Math.abs(seatPositions[i] - studentPositions[i]);
        }
        return totalMoves;
    }
}
