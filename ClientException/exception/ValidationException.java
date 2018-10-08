package exception;

public class ValidationException extends Exception  {
	
	public ValidationException(String s)
	{
		 super(s);
	}
	

}


 class ClientException
{
	void valuenotEntered( )throws ValidationException
	
	{
		
		throw new ValidationException("Value not Entered");
	}
	
	public static void main(String args[])
    {
		ClientException obj = new ClientException();
        try
        {
           obj.valuenotEntered();
        }
        catch (ValidationException ex)
        {
            System.out.println("Caught the exception");
            System.out.println(ex.getMessage());
        }
    }
	
}