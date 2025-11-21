# Department-store

### <ins>Schedule</ins> class
Added one more constructor: 

    public Schedule(Weekday weekday, LocalDateTime startTime, LocalDateTime endTime)

Added methods:

    getToday()
    addSchedule()


### <ins>Empolyee</ins> class

Changed the attributes visibility from `private` to `protected` because this is abstract class and subclasses need those attributes. <del>`private`</del> -> `protected`

    protected int employeeId;
	protected String name;
	protected String position;
	protected double salary;
	protected ArrayList<HashMap<String, Object>> promotionHistory;</code></pre>