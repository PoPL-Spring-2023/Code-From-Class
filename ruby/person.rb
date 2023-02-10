class Person

    ### This creates a getter and a setter for age
    attr_accessor :age

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



end