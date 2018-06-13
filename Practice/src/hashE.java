
public class hashE {

	int a=12200;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		hashE other = (hashE) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		return true;
	}

	int b=1111;
	
	public static void main(String[] args) 
	{
	
		String str="hello";
		String str1="hello";
		System.out.println(str.hashCode());
		System.out.println(str1.hashCode());
		
		
		hashE h=new hashE();
		hashE h1=new hashE();
		System.out.println(h);
		
		
		System.out.println(h1);
        System.out.println(h.hashCode());
		System.out.println(h1.hashCode());
	}

}
