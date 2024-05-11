# Observer y Strategy

- **Propósito**: Define una dependencia de uno a muchos entre objetos de forma tal que cuando un objeto cambie se
  notifique a todos los objetos que dependen de él.
- **Push vs Pull model**: Observen que el método `Observable.notificar` recibe un `String` por parámetro. Éste es el
  modelo push ya que es el observado quien envía la información que cambió a los observadores. En en el modelo pull solo
  se lo notifica (sin pasar parámetros) pero cada observer debe conocer al observado de modo tal de pedirle aquello que
  cambió.
    - El modelo pull acopla los observadores a los observados. El observer debe conocer qué método del observado debe
      invocar. Y además los observados deben exponer mediante un método aquel estado que cambió (getter? y el
      encapsulamiento?).
    - El método push hace menos reusables a los observadores porque siempre necesitan algun tipo fijo en la firma
      de `notificar`. Podriamos usar un `Map` como parámetro en lugar de un `String` lo cual lo haría un poco más
      flexible.
