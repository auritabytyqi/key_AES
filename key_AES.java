public class key_AES {

    public static void main (String [] args)
    { 
        boolean [] a={true,true,false,false,true,false,true,false,true,true,true,true,false,false,false,true};// 1100101011110001
        boolean[] b=new boolean[16];
        boolean [] rc1={false,false,false,true};
        boolean [] rc2={false,false,true,false};
        boolean [] rc3={false,true,false,false};
        b=gjenerimi_i_celesit(a, rc1);
        b=gjenerimi_i_celesit(b,rc2);
        b=gjenerimi_i_celesit(b,rc3);
        for(boolean e: b)
        {System.out.print(e+ " ");}

    }
    public static boolean [] gjenerimi_i_celesit(boolean [] k0, boolean [] rc)
    {   boolean[] b0=new boolean[4];
        boolean[] b1=new boolean[4];
        boolean[] b2=new boolean[4];
        boolean[] b3=new boolean[4];
        for (int i=0; i<4; i++)
        {
            b0[i]=k0[i];
            b1[i]=k0[i+4];
            b2[i]=k0[i+8];
            b3[i]=k0[i+12];

        }
       
        boolean [] b4=new boolean[4]; //pas g
        b4=g(b3,rc);
        boolean [] ki=new boolean[k0.length]; // rez ki
        for(int i=0; i<4; i++)
        { ki[i]=b0[i]^b4[i];}
        for(int i=4; i<8; i++)
        { ki[i]=ki[i-4]^b1[i-4];}
        for(int i=8; i<12; i++)
        { ki[i]=ki[i-4]^b2[i-8];}
        for(int i=12; i<16; i++)
        { ki[i]=ki[i-4]^b3[i-12];}

  


      
      return ki;
    }
    public static boolean [] g(boolean [] a, boolean [] rc)
    {
        boolean [] b=new boolean[a.length]; // zhvendosja
        b[0]=a[1];
        b[1]=a[2];
        b[2]=a[3];
        b[3]=a[0];
       
        boolean [] s_box=new boolean[4];
        s_box=sbox(b);
        boolean[] rez=new boolean[4];
        for (int i=0; i<rez.length; i++)
        {
            rez[i]=s_box[i]^rc[i];
        }
        return rez;
    }
    
    public static boolean [] sbox(boolean [] a)
    {  boolean [] after_sbox=new boolean[4];
        char [][] s_box=new char [4][4];
       s_box [0][0]='6';
       s_box [0][1]='B';
       s_box [0][2]='0';
       s_box [0][3]='4';
       s_box [1][0]='7';
       s_box [1][1]='E';
       s_box [1][2]='2';
       s_box [1][3]='F';
       s_box [2][0]='9';
       s_box [2][1]='8';
       s_box [2][2]='A';
       s_box [2][3]='C';
       s_box [3][0]='3';
       s_box [3][1]='1';
       s_box [3][2]='5';
       s_box [3][3]='D';
       int [] aa=new int[4];
       for (int i=0; i<aa.length; i++)
       {if(a[i])
        {aa[i]=1;}
       else {aa[i]=0;}}
       int j=aa[0]*2+aa[1]*1;
       int k=aa[2]*2+aa[3]*1;
       char c_sbox=s_box[j][k]; // vlera nga sbox
       Binary_Hexadecimal b=new Binary_Hexadecimal();
       after_sbox=b.hex_to_bin(c_sbox);
       return after_sbox;
    }
}
