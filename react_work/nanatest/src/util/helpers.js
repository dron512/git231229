export function qs(selector, scope = document) {
  if (!selector) throw "no selector";

  return scope.querySelector(selector);
}
