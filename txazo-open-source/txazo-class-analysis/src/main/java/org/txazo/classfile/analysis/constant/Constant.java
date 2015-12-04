package org.txazo.classfile.analysis.constant;

public final class Constant {

    public static final int magic = 0xCAFEBABE;

    public enum Access_Flags {

        ACC_PUBLIC(0x0001),
        ACC_FINAL(0x0010),
        ACC_SUPER(0x0020),
        ACC_INTERFACE(0x0200),
        ACC_ABSTRACT(0x0400),
        ACC_SYNTHETIC(0x1000),
        ACC_ANNOTATION(0x2000),
        ACC_ENUM(0x4000);

        private int hex;

        Access_Flags(int hex) {
            this.hex = hex;
        }

    }

    public static void main(String[] args) {
        System.out.println((long) 0xCAFEBABE);
        System.out.println(Long.parseLong("CAFEBABE", 16));

        System.out.println(Long.parseLong("FF", 16));
        System.out.println(Long.parseLong("FFFF", 16));
        System.out.println(Long.parseLong("FFFFFFFF", 16));

        System.out.println((long) 0xFF);
        System.out.println((long) 0xFFFF);

        System.out.println((long) 0xFFFFFFFE);
        System.out.println((long) 0xEFFFFFFF);

        System.out.println(Integer.parseInt("FF", 16));
        System.out.println(Integer.parseInt("FFFF", 16));
        System.out.println(Long.parseLong("FFFFFFFF", 16));
    }

}
