package Totocalcio;


public record Pair(int i , int j ){
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(6);
        sb.append("<");
        sb.append(i);
        sb.append(",").append(j);
        sb.append('>');
        return sb.toString();
    }
}