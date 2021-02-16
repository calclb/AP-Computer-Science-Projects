package Chapter5.Project5_5;


// Note that this class includes the changes made from Projects 5.3 and 5.4.
public class Task implements Priority, Complexity, Comparable
{
    private int priority;
    private int complexity;

    public Task(int p, int c)
    {
        priority = p;
        complexity = c;
    }

    @Override public int getPriority() { return priority; }
    @Override public void setPriority(int p) { priority = p; }

    @Override public void setComplexity(int complexity) { this.complexity = complexity; }
    @Override public int getComplexity() { return complexity; }

    @Override
    public int compareTo(Object o)
    {
        int otherPriority = ((Task) o).getPriority();
        // alternatively, use Integer.compare(priority, otherPriority)
        return priority > otherPriority ? 1 : priority < otherPriority ? -1 : 0;
    }
}
