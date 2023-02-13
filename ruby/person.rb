class Person

    ## Class variable shared between all instances
    @@id_number_tracker = 0

    ### This creates a getter and a setter for age
    attr_accessor :age
    attr_reader :id_number

    ### attr_reader - creates a getter
    ### attr_writer - creates a setter

    # Initializes the person object:
    # Constructor:
    def initialize(full_name, age)
        if age.class != Integer
            age = age.to_i
        end 
        @name = full_name
        @age = age
        assign_id
    end

    def name=(new_name)
        @name = new_name
        puts "Hahaha you changed your name to #{@name}"
    end

    def name
        puts "in the name method"
        @name
    end

    # Increments age by 1
    def birthday
        @age += 1
    end

    # Takes another person as its parameter, and prints an introduction
    def introduce(other_person)
        puts "Hello #{other_person}, my name is #{@name}. I am #{@age} years old."
    end

    # Overrides the default to_s method
    # Called whenever a string representation of a person is needed
    def to_s
        @name
    end

    def assign_id
        @id_number = @@id_number_tracker
        @@id_number_tracker += 1
    end


end