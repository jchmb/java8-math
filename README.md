Java 8 Math Library
===================

Features
--------

* Field interface for generalizing operations on fields. This makes it possible to define a vector over a field, without having to specify the field. This can easily be extended to complex numbers, and more.
* A Vector class that is defined over some abstract field. Also comes with convenience methods such as Vector.ofDouble(List<Double> values), Vector.of(double x, double y), and Vector.of(double x, double y, double z).